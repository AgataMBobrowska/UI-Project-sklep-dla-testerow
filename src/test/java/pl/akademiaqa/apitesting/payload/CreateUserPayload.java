package pl.akademiaqa.apitesting.payload;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserPayload {

    private String name;

    @SerializedName("username")
    private String userName;

    private String email;



}
