import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MCardsTest {
	private String readFile(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	private static Stream<Object[]> testCases() throws IOException {
		String testCasesDir = "src/test/testfiles/";

		return Files.list(Paths.get(testCasesDir))
				.filter(path -> path.toString().endsWith(".in"))
				.map(path -> new Object[]{path.toString(), path.toString().replace(".in", ".out")})
				.filter(pair -> Files.exists(Paths.get(pair[1].toString())))
				.toList()
				.stream();
	}

	@ParameterizedTest(name = "Test {index}: {0}")
	@MethodSource("testCases")
	void testFromFiles(String inputFile, String outputFile) throws IOException {
		String input = readFile(inputFile);
		int expectedOutput = Integer.parseInt(readFile(outputFile).trim());

		Scanner sc = new Scanner(input);
		int c = sc.nextInt();
		int n = sc.nextInt();

		List<MCards.Pair> card = new ArrayList<>();
		for (int i = 0; i < c * n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			card.add(new MCards.Pair(x, y));
		}

		int actualOutput = MCards.minimumSwaps(c,n,card);
		assertEquals(expectedOutput, actualOutput);
	}
}