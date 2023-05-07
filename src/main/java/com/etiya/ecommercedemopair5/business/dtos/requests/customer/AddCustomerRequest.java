package com.etiya.ecommercedemopair5.business.dtos.requests.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {


    @NotBlank(message = "İsim alanı boş olmamalıdır.")
    @NotNull(message = "İsim alanı null olamaz.")
    private String firstName;

    @NotBlank(message = "İsim alanı boş olmamalıdır.")
    @NotNull(message = "İsim alanı null olamaz.")
    private String lastName;

    @Email(message = "Geçerli email girilmedi.")
    private String email;

    @Size(min = 10)
    private String phoneNumber;

    //TODO: Adres isteme eklenebilir.
}
