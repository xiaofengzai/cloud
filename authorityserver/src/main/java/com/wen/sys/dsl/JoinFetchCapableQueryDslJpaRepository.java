//package com.wen.sys.dsl;
//
//import com.querydsl.core.types.Predicate;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
//
//import java.util.List;
//import java.util.function.Function;
//
//public interface JoinFetchCapableQueryDslJpaRepository<T> extends QuerydslPredicateExecutor<T> {
//    T findOne(Predicate predicate, JoinDescriptor joinDescriptor);
//
//    List<T> findAll(Predicate predicate, JoinDescriptor joinDescriptor);
//
//    Page<T> findAll(Predicate predicate, Pageable pageable, JoinDescriptor joinDescriptor);
//
//    long count(Predicate predicate, JoinDescriptor joinDescriptor);
//
//    boolean exists(Predicate predicate, JoinDescriptor joinDescriptor);
//
//    <V> V findOne(Function<JPAQueryFactory, JPAQuery<V>> createQueryFactory);
//
//    <V> List<V> findAll(Function<JPAQueryFactory, JPAQuery<V>> createQueryFactory);
//
//    <V> Page<V> findAll(Function<JPAQueryFactory, JPAQuery<V>> createQueryFactory, Pageable pageable);
//
//    <V> long count(Function<JPAQueryFactory, JPAQuery<V>> createQueryFactory);
//
//    <V> boolean exists(Function<JPAQueryFactory, JPAQuery<V>> createQueryFactory);
//}