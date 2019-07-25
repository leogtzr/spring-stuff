import java.util.ArrayList;
import java.util.List;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringTransformApp {
	public static void main(final String[] args) {
		final List<String> urls = List.of(
            "   http://google.com/",
            "http://my.search.com?query=java server&page=1");

		// System.out.println(urls);
		final List<String> transformedURLS = new ArrayList<>();
		for (final String url : urls) {
			final String transformedURL = url.transform(String::strip)
				.transform(StringTransformApp::encodeQueryParams);
				transformedURLS.add(transformedURL);
		}

		transformedURLS.forEach(System.out::println);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~>");

		final List<String> strs = List.of("Abc", "Leo", " Ok", "amm");

		strs.forEach(s -> {
			System.out.println(s.transform(String::toUpperCase).transform(String::strip));
		});

	}

	public static String encodeQueryParams(String rawURL) {
        try {
            if (rawURL.contains("?")) {
                String[] splitURL = rawURL.split("\\?");
                return splitURL[0] + "?" +
                        URLEncoder.encode(splitURL[1], "UTF-8");
            }
            return rawURL;
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("UTF-8 not supported", ex);
        }
    }


}