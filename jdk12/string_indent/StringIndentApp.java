public class StringIndentApp {
    public static void main(final String[] args) {
        final StringBuilder yaml = new StringBuilder();
        yaml.append("spec:\n");
        yaml.append("containers:\n".indent(2));
        yaml.append("- name: nginx\n".indent(2));
        yaml.append("image: nginx:1.7.9".indent(4));

        System.out.println(yaml.toString());
    }
}

/*
Output:

spec:
  containers:
  - name: nginx
    image: nginx:1.7.9

*/