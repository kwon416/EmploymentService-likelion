package io.cloudtype.Demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(description = "sample DTO")
public class SampleDto {
    @Schema(description = "sample ID")
    private Long id;
    @Schema(description = "sample DATA")
    private String data;

    public SampleDto(Long id, String data) {
        this.id = id;
        this.data = data;
    }
}
