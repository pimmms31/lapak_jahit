package cilok.com.lapakjahit.callback;

import cilok.com.lapakjahit.entity.ProductFavorite;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gilbert on 5/19/2017.
 */

public interface FavoriteService {
    @GET("favorites.json")
    Call<ProductFavorite> getFavorites(@Query("page") int page);

    @GET("favorites.json")
    Call<ProductFavorite> getFavorites();
}
