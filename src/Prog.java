import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Prog {

	private static void euler1() {
		IntStream.range(0, 1000).filter((v) -> v % 3 == 0 || v % 5 == 0).reduce((v1, v2) -> v1 + v2)
				.ifPresent(System.out::println);
	}

	private static void euler2() {
		List<Integer> fibs = new ArrayList<Integer>();
		fibs.add(1);
		fibs.add(2);
		int i = 2;
		int nextFib = fibs.get(i - 1) + fibs.get(i - 2);
		while (nextFib < 4000000) {
			fibs.add(nextFib);
			i++;
			nextFib = fibs.get(i - 1) + fibs.get(i - 2);
		}
		fibs.stream().filter(v -> v % 2 == 0).reduce((v1, v2) -> v1 + v2).ifPresent(System.out::println);
	}

	private static void euler3() {
		long prod = 600851475143L;
		long maxRange = prod;
		for (long i = 2; i < maxRange; i++) {
			if (maxRange % i == 0)
				maxRange = maxRange / i;
		}
		System.out.println(maxRange);
	}

	private static void euler4() {
		int maxPaly = 0;
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				int prod = i * j;
				int count = 0;
				int remainder = prod;
				int[] numArr = new int[6];
				while (remainder != 0) {
					numArr[count++] = remainder % 10;
					remainder /= 10;
				}

				if (numArr[0] == numArr[5] && numArr[1] == numArr[4] && numArr[2] == numArr[3]) {
					if (prod > maxPaly)
						maxPaly = prod;
				}
			}
		}
		System.out.println(maxPaly);
	}

	private static void euler5() {
		boolean found = false;
		int current = 0;
		while (!found) {
			final int num = current += 20;
			if (IntStream.range(2, 21).allMatch(v -> num % v == 0)) {
				found = true;
				System.out.println(num);
			}
		}
	}

	private static void euler6() {
		long sumOfSquared = LongStream.range(1, 101).map(v -> v * v).reduce((v1, v2) -> v1 + v2).getAsLong();
		long squaredOfSum = (long) Math.pow(LongStream.range(1, 101).reduce((v1, v2) -> v1 + v2).getAsLong(), 2);
		System.out.println(squaredOfSum - sumOfSquared);
	}

	private static void euler7() {
		int primeCount = 0;
		int currentPrime = 1;
		final int someLargeNumber = 10000000;
		while (primeCount < 10001) {
			for (int i = currentPrime + 1; i < someLargeNumber; i++) {
				final int final_i = i;
				if (IntStream.range(2, final_i).noneMatch(v -> final_i % v == 0)) {
					currentPrime = final_i;
					primeCount++;
					break;
				}
			}
		}
		System.out.println(currentPrime);
	}

	private static void euler8() {
		String num = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		BigInteger max = new BigInteger("0");
		for (int i = 0; i < num.length() - 13; i++) {
			BigInteger prod = new BigInteger("1");
			for (int j = i; j < i + 13; j++) {
				String current = num.substring(j, j + 1);
				prod = prod.multiply(new BigInteger(current));
				if (num.charAt(j) == '0')
					break;
			}
			if (prod.compareTo(max) == 1) {
				max = prod;
			}
		}
		System.out.println(max);

	}

	private static void euler9() {
		for (int a = 1; a <= 1000; a++) {
			for (int b = 1; b < 1000; b++) {
				int c = 1000 - a - b;
				if (a * a + b * b == c * c) {
					System.out.println(a * b * c);
					return;
				}
			}
		}
	}

	private static void euler10() {
		
	}

	private static void eulerx() {

	}

	private static void eulerxxy() {

	}

	private static void eulerxxxy() {

	}

	private static void eulerxyy() {

	}

	private static void eulerxyyy() {

	}

	public static void main(String[] args) {
		euler10();
	}
}
