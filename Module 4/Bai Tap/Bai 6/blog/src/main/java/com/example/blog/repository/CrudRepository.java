package com.example.blog.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
    <S extends T>S save(S entity);  //Save một entity đã cho.

    <S extends T > Iterable < S > saveAll(Iterable < S > entities);  //-Save tập hợp Entity.

    Optional<T> findById(ID primaryKey);  //Tìm entity theo ID.

    Iterable<T> findAll( ); //Trả về tất cả instances của type.

    Iterable < T > findAllById(Iterable < ID > ids);   //Trả về tất cả instance của type với ID.

    long count();  // tra ve so luong entity

    void delete(T entity);  // xoa 1 entity

    void deleteById(ID id);  // xoa entity theo id

    void deleteAll();  // xoa tat ca entity

    boolean existsById(ID primaryKey);  // tra ve co hay khong 1 entity


}
