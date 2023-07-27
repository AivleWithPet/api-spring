package com.example.apispring.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDisease is a Querydsl query type for Disease
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDisease extends EntityPathBase<Disease> {

    private static final long serialVersionUID = -673035959L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDisease disease = new QDisease("disease");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPet pet;

    public final DateTimePath<java.time.LocalDateTime> receiptAt = createDateTime("receiptAt", java.time.LocalDateTime.class);

    public QDisease(String variable) {
        this(Disease.class, forVariable(variable), INITS);
    }

    public QDisease(Path<? extends Disease> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDisease(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDisease(PathMetadata metadata, PathInits inits) {
        this(Disease.class, metadata, inits);
    }

    public QDisease(Class<? extends Disease> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pet = inits.isInitialized("pet") ? new QPet(forProperty("pet"), inits.get("pet")) : null;
    }

}

