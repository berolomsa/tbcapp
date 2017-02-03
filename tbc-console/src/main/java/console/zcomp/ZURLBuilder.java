package console.zcomp;


import java.util.Map;
import java.util.TreeMap;

public class ZURLBuilder {
	private String baseURL;
	private String path;
	private Map<String, Object> params;

	private ZURLBuilder(String baseURL, String path) {
		this.baseURL = baseURL;
		this.path = path;
		this.params = new TreeMap<>();
	}

	public ZURLBuilder param(String name, Object value) {
		params.put(name, value);
		return this;
	}

	public String build() {
		StringBuilder builder = new StringBuilder();

		if (baseURL != null) {
			builder.append(baseURL.replaceAll("/+$", ""));
		}

		if (path != null) {
			String cleanPath = path.replaceAll("^/+(.*?)/+$", "$1");

			if (cleanPath.length() > 0) {
				builder.append("/").append(cleanPath);
			}
		}

		String queryString = getQueryString();

		if (queryString.length() > 0) {
			builder.append("?").append(queryString);
		}

		return builder.toString();
	}

	public String getQueryString() {
		StringBuilder builder = new StringBuilder();

		if (params.size() > 0) {
			int count = 0;

			for (Map.Entry<String, Object> entry : params.entrySet()) {
				builder.append(entry.getKey());
				builder.append("=");
				builder.append(String.valueOf(entry.getValue()));

				if (++count < params.size()) {
					builder.append("&");
				}
			}
		}

		return builder.toString();
	}

	public static ZURLBuilder create(String baseURL) {
		return create(baseURL, null);
	}

	public static ZURLBuilder create(String baseURL, String path) {
		return new ZURLBuilder(baseURL, path);
	}
}
