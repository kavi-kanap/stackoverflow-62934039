package com.example.composite;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);

		IIOTShiftModelRepository shiftModelRepository = context.getBean(IIOTShiftModelRepository.class);
		IIOTMachineModelRepository machineModelRepository = context.getBean(IIOTMachineModelRepository.class);
		IIOTProductModelRepository productModelRepository = context.getBean(IIOTProductModelRepository.class);

		IIOTMachineModel iiotMachineModel = new IIOTMachineModel("machine-id-1", "machine one", "machine one dec", LocalDateTime.now());
		iiotMachineModel = machineModelRepository.save(iiotMachineModel);
		IIOTProductModel iiotProductModel = new IIOTProductModel("product1", iiotMachineModel, "lineId", "variant", null, "opname");
		productModelRepository.save(iiotProductModel);
		IIOTShiftModel iiotShiftModel = new IIOTShiftModel("shiftId", iiotMachineModel, LocalTime.now(), LocalTime.now(), LocalDateTime.now());
		shiftModelRepository.save(iiotShiftModel);
		iiotProductModel.setShift(iiotShiftModel);
		iiotProductModel = productModelRepository.save(iiotProductModel);

		IIOTProductModelPK iiotProductModelPK = new IIOTProductModelPK();
		iiotProductModelPK.setMachine(iiotProductModel.getMachine().getMachineId());
		iiotProductModelPK.setProductId(iiotProductModel.getProductId());
		productModelRepository.findById(iiotProductModelPK);




	}

}