package com.dgnklz.studentteachertraining.core.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forRequest();
	ModelMapper forResponse();
}
