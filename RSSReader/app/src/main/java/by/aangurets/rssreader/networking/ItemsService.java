package by.aangurets.rssreader.networking;

import java.util.List;

import by.aangurets.rssreader.model.Item;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by aangurets on 06/12/2015.
 */
public interface ItemsService {

    @GET("/{path}/feed")
    List<Item> listItems(@Path("path") String path);

}
