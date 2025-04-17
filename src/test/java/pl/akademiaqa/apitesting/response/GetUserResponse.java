package pl.akademiaqa.apitesting.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetUserResponse {

    private int id;
    private String name;
    @SerializedName("username")
    private String userName;
    private String email;
}
