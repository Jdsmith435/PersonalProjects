package com.programming.main2048.grp;

public class Sprite {

	public int width, height;
	public int[] pixels;
	
	public Sprite(int width, int height, int color) {
	this.width = width;
	this.height = height;
	this.pixels = new int[width*height];
		
	/*
	 * This for loop will assign each pixel a color
	 * 
	 * Looping through each x in each y column, a color is assigned to each 
	 * index of pixel[] which has 10,000 indexes.
	 * If the x or the y divided by a 100 has a remainder that 
	 * is less than 3 or greater than 97, the pixel index is assigned to the base gray.
	 */
	for( int y =0; y <height; y++) {
		for ( int x = 0; x < width; x++) {
			pixels[x + y * width] = color;
			
			if( x % 100 < 3 || x % 100 > 97 || y % 100 < 3 || y % 100 > 97) {
				pixels[x + y * width] = 0xffff00ff;
			}
		}
	}
	}

}
