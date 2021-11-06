package DP;

public class TrappingRainWater {
	 public int trap(int[] height) {
	int lMax = 0, rMax = 0;
	int water = 0;
	int l = 0, r = height.length - 1;
	while(l < r) {
		if(height[l] < height[r]) {
			if(height[l] >= lMax) {
				lMax = height[l];
			}else {
				water += lMax - height[l];
			}
			l++;
		}else {
			if(height[r] >= rMax) {
				rMax = height[r];
			}else {
				water += rMax - height[r];
			}
			r--;
		}
	}
	return water;
}
}
