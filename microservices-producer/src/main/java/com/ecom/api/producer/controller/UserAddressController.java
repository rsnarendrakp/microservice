package com.ecom.api.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.producer.domain.UserAddress;
import com.ecom.api.producer.service.UserAddressService;
import com.ecom.api.producer.service.util.NextSequenceService;
import com.ecom.api.producer.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "user/address/")
@Api(value = "User address resource to handle all user address related action and queries")
public class UserAddressController {

	@Autowired
	UserAddressService userAddressService;
	@Autowired
	NextSequenceService nextSequenceService;

	@PostMapping
	    @ApiOperation(value = "Create user address details in the System")
	    @ApiResponses(value = {
	                @ApiResponse(code = 200, message = "Successfully saved/created "),
	                @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	                @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	                @ApiResponse(code = 404, message = "Requested Resource Not Found")})
	    public void saveUserAddress(@RequestBody UserAddress userAddress) {
	    	if(userAddress.getId()==0) {
	    		userAddress.setId(nextSequenceService.getNextSequence(Constants.USER_ADDRESS_SEQUENCE_NAME));
	    	}
	    	userAddressService.saveUserAddress(userAddress);
	    }

	@GetMapping
	@ApiOperation(value = "Returns list of user address", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Requested Resource Not Found") })
	public List<UserAddress> getAllUserAddress() {
		return userAddressService.getAllAddress();
	}
}
