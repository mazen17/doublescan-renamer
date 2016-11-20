package com.georgiev.rename.app;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Renamer r = new Renamer();
		r.getForwardFileNames("f");
		r.getBackwardFileNames("b");
	}
}
