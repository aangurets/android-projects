package by.aangurets.rssreader.networking;

import by.aangurets.rssreader.Constants;
import retrofit.RestAdapter;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by aangurets on 06/12/2015.
 */
public class ItemsServiceHolder {

    private static final class InstanceHolder {
        static final ItemsService INSTANCE;

        static {
            RestAdapter.Builder builder = new RestAdapter.Builder();
            builder.setEndpoint(Constants.RMF_ENDPOINT);
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
            builder.setConverter(new SimpleXMLConverter());
            INSTANCE = builder.build().create(ItemsService.class);
        }
    }

    public static ItemsService getService() {
        return InstanceHolder.INSTANCE;
    }

    private ItemsServiceHolder() {
    }
}
