package subway.requests;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class SectionRequests {
    public static ExtractableResponse<Response> 지하철구간_추가_요청하기(String lineId, String upStationId, String downStationId, int distance) {
        Map<String, String> params = new HashMap<>();
        params.put("upStationId", upStationId);
        params.put("downStationId", downStationId);
        params.put("distance", String.valueOf(distance));

        return RestAssured.given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/lines/" + lineId + "/sections")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 지하철구간_삭제_요청하기(String lineId, String stationId) {
        Map<String, String> params = new HashMap<>();
        params.put("stationId", stationId);

        return RestAssured.given().log().all()
                .params(params)
                .when().delete("/lines/" + lineId + "/sections")
                .then().log().all()
                .extract();
    }
}
