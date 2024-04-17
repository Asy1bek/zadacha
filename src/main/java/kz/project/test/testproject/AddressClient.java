package kz.project.test.testproject;

import kz.project.test.model.Address;
import kz.project.test.model.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/address-service")
public interface AddressClient {

    @GetMapping("/address/{id}")
    ResponseEntity<Address> getAddress(@PathVariable("id") Long id);

    @PostMapping("/address")
    ResponseEntity<Address> saveAddress(@RequestBody AddressDto addressDto);
}