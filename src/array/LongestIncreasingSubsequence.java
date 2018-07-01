package array;

/**
 * 最长递增子序列
 * 子数组是连续的
 * 子序列可以是不连续的
 *
 * @return 序列的长度
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = new int[]{2, 1, 6, 4, 5, 2, 7, 4};
//		int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
		System.out.println(solution_one(arr));
		System.out.println(solution_two(arr));
		System.out.println(solution_three(arr));
	}

	/**
	 * 时间复杂度 O(n2)
	 * tmp[i]存储的是
	 * 以arr[i]结束的递增子序列的长度
	 * 求法： 遍历i到0找到 比i小的tmp最大值
	 */
	public static int solution_one(int[] arr) {
		int[] tmp = new int[arr.length];
		tmp[0] = 1;
		int re_max = 1;
		for (int i = 1; i < arr.length; i++) { // 遍历从i到length
			int arr_i = arr[i], i_max = 1; // 找到从i开始到0，tmp中的最大值
			boolean is_find_min = false; // 是否找到比arr_i小的元素
			for (int j = i - 1; j >= 0; j--) { // 遍历从i到0
				if (arr[j] < arr_i) {
					is_find_min = true;
					if (tmp[j] > i_max) i_max = tmp[j];
				}
			}
			i_max = is_find_min ? i_max + 1 : 1;
			tmp[i] = i_max;

			if (i_max > re_max) {
				re_max = i_max;
			}
		}
		return re_max;
	}

	/**
	 * 时间复杂度 O(n2)
	 * h存储的是递增子序列
	 * 遍历arr确保h为递增
	 */
	public static int solution_two(int[] arr) {
		int[] h = new int[arr.length];
		h[0] = arr[0];
		int valid_length = 1; // 有效区域的长度
		for (int i = 1; i < arr.length; i++) {
			int arr_i = arr[i];
			if (arr_i > h[valid_length - 1]) { // 当前arr_i大于有效区的最大值(最后一个值)
				h[valid_length++] = arr_i; // 扩充有效区
			} else for (int j = 0; j < valid_length; j++) { // 遍历查找第一个大于arr_i的值并替换
				if (h[j] > arr_i) {
					h[j] = arr_i;
					break;
				}
			}
		}
		return valid_length;
	}

	/**
	 * 时间复杂度 O(n*logn)
	 * 二分
	 */
	public static int solution_three(int[] arr) {
		int[] h = new int[arr.length];
		h[0] = arr[0];
		int valid_length = 1; // 有效区域的长度
		for (int i = 1; i < arr.length; i++) {
			int arr_i = arr[i];
			// 二分查找 arr_i 在有效区中的位置
			int l = 0, r = valid_length - 1;
			while (l <= r) {
				int mid = (l + r) >> 1;
				if (arr_i > h[mid]) l = mid + 1;
				else if (arr_i < h[mid]) r = mid - 1;
				else break;
			}
			// arr_i大于左值
			if (arr_i > h[l]) valid_length++;
			h[l] = arr_i;
		}
		return valid_length;
	}

}
