package com.threedsoft.packing.dto.events;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.threedsoft.packing.dto.requests.PackConfirmRequestDTO;
import com.threedsoft.util.dto.events.ExceptionEvent;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class PackConfirmationFailureEvent extends ExceptionEvent{
	public PackConfirmationFailureEvent(PackConfirmRequestDTO req, String serviceName, String errorMsg) {
		this(req, serviceName, errorMsg, null);
	}

	public PackConfirmationFailureEvent(PackConfirmRequestDTO req, String serviceName, String errorMsg, Exception exObj) {
		this(req, serviceName, errorMsg, exObj, null);
	}

	public PackConfirmationFailureEvent(PackConfirmRequestDTO req, String serviceName, String errorMsg, Exception exObj,
			Map headerMap) {
		super("PackConfirmationFailureEvent", req.getBusName(), req.getLocnNbr(), req.getCompany(), req.getDivision(),
				req.getBusUnit(), "Order", req.getOrderNbr(), serviceName, req, errorMsg, exObj);
		if (headerMap != null)
			this.setHeaderMap(headerMap);
	}
}
