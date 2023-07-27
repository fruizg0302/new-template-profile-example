package com.paloit.profile.server.grpc;

import com.google.protobuf.StringValue;

import org.mapstruct.Mapper;

/**
 * Mapper for Google protobuf data types
 */
@Mapper
public interface ProtobufMapper {
  default String stringValueToString(StringValue value){
    return value.getValue();
  }
  default StringValue stringToStringValue(String value){
    return StringValue.of(value);
  }
}
