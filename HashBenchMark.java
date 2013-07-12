package hash;

import java.text.NumberFormat;
import java.util.HashMap;

public class HashBenchMark {

	public static void main(String[] args) {

		hash.ChainHash test1 = new hash.ChainHash();
		hash.OpenAdressHash test2 = new hash.OpenAdressHash();
		HashMap map = new HashMap();

		// //ChainHashMap

		long currentstart = System.currentTimeMillis();

		// 計測したい処理
		for (int i = 0; i < 500; i++) {
			test1.Set(i, 1);
			test1.Set(100 + 1000 * i, 1);
		}
		for (int i = 0; i < 500; i++) {
			test1.Get(i);
			test1.Get(100 + 1000 * i);
		}
		long currentstop = System.currentTimeMillis();
		NumberFormat currentformat = NumberFormat.getNumberInstance();
		System.out.println("ChainHash処理時間は\n"
				+ currentformat.format((currentstop - currentstart)) + "ms");

		test1.Init();

		// //OpenAdressHashMap

		currentstart = System.currentTimeMillis();

		// 計測したい処理
		for (int i = 0; i < 500; i++) {
			test1.Set(i, 1);
			test1.Set(100 + 1000 * i, 1);
		}
		for (int i = 0; i < 500; i++) {
			test1.Get(i);
			test1.Get(100 + 1000 * i);
		}

		currentstop = System.currentTimeMillis();
		currentformat = NumberFormat.getNumberInstance();
		System.out.println("OpenAdressHash処理時間は\n"
				+ currentformat.format((currentstop - currentstart)) + "ms");

		test2.Init();

		// //　JavaHashMap

		currentstart = System.currentTimeMillis();

		// 計測したい処理
		for (int i = 0; i < 500; i++) {
			map.put(i, 1);
			map.put(100 + 1000 * i, 1);
		}
		for (int i = 0; i < 500; i++) {
			map.get(i);
			map.get(100 + 1000 * i);
		}

		currentstop = System.currentTimeMillis();
		currentformat = NumberFormat.getNumberInstance();
		System.out.println("JavaHash処理時間は\n"
				+ currentformat.format((currentstop - currentstart)) + "ms");

	}
}
