package jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {

	public static void main(String[] args) {
		String a = "abc";
		SoftReference<String> soft = new SoftReference<String>(a);
		WeakReference<String> weak = new WeakReference<String>(a);
	}
}
