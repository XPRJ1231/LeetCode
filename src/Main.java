
public class Main {
    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }

        for (; i < n; i++) {
            nums[i] = 0;
        }
    }
}
