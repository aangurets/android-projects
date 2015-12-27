package by.aangurets.rssreader.networking;

import by.aangurets.rssreader.model.Channel;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by aangurets on 06/12/2015.
 */
public interface ItemsService {

    @GET("/{path}/feed")
    Channel listItems(@Path("path") String path);

}
