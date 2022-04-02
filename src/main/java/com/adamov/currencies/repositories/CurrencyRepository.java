package com.adamov.currencies.repositories;

import com.adamov.currencies.entites.Currency;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface CurrencyRepository{

    @Select("select * from Currencies")
    List<Currency> findAll();

    @Select("select * from Currencies where id=#{id}")
    Currency findById(Long id);

    @Update("update Currencies SET currency=#{updateValue} where id=#{id}")
    boolean updateCurrency(Long id, String updateValue);

}
