/**
 * ����������СΪ m �� n ���������� nums1 �� nums2��
 * �ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))��
 * ���Լ��� nums1 �� nums2 ����ͬʱΪ�ա�
 * ʾ�� 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * ����λ���� 2.0
  
 * ʾ�� 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * ����λ���� (2 + 3)/2 = 2.5
 */

public class FindMedianSortedArrays {

	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) {
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax + 1) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1;
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1;
			} else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n + 1) % 2 == 1) {
					return maxLeft;
				}
				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

}
