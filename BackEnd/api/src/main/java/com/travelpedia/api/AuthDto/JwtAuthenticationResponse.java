package com.travelpedia.api.AuthDto;
//package com.example.travelpediabackendjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
  String token;
  Boolean status;
  String message;
}
