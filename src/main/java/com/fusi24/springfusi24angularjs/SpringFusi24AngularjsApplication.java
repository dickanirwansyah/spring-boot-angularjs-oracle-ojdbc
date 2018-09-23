package com.fusi24.springfusi24angularjs;

import com.fusi24.springfusi24angularjs.entity.City;
import com.fusi24.springfusi24angularjs.entity.Province;
import com.fusi24.springfusi24angularjs.repository.CityRepository;
import com.fusi24.springfusi24angularjs.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringFusi24AngularjsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFusi24AngularjsApplication.class, args);
	}
}

@Component
class insertDataCity implements CommandLineRunner {

	@Autowired
	ProvinceRepository provinceRepository;

	@Override
	public void run(String... args) throws Exception {

		String[] data = {
				"Sumatra",
				"Aceh",
				"Jawa",
				"Kalimantan",
				"Bali",
				"Kalimantan Barat",
				"Kalimantan Timur",
				"Nusa Tenggara Timur",
				"Nusa Tenggara Barat",
				"Papua",
				"Ambon",
				"Maluku",
				"Maluku Utara"
		};

		for (int i = 1; i < data.length; i++){
			provinceRepository.save(Province
			.builder()
			.name(data[i].toUpperCase())
			.build());
		}
	}
}