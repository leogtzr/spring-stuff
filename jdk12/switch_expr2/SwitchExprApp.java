import java.net.URI;
import java.net.URISyntaxException;

public class SwitchExprApp {

    private enum StorageType {
        LOCAL_FILE,
        CLOUD
    }

    public static void main(final String[] args) throws URISyntaxException {
        final StorageType type = StorageType.LOCAL_FILE;
        
        final URI result = switch (type) {
            case LOCAL_FILE -> {
                System.out.println("Retrieving the local file " +
                        "storage URI");
                break new URI("file://~/storage");
            }
            case CLOUD -> {
                System.out.println("Retrieving the cloud storage URI");
                break new URI("http://mycloud.com/data");
            }
            default -> throw new
                    IllegalArgumentException("Unknown storage type");
        };
    }

}