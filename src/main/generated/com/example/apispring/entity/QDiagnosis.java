package com.example.apispring.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiagnosis is a Querydsl query type for Diagnosis
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDiagnosis extends EntityPathBase<Diagnosis> {

    private static final long serialVersionUID = -1268497538L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDiagnosis diagnosis = new QDiagnosis("diagnosis");

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final QDisease disease;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPet pet;

    public final StringPath PhotoName = createString("PhotoName");

    public final StringPath PhotoPath = createString("PhotoPath");

    public QDiagnosis(String variable) {
        this(Diagnosis.class, forVariable(variable), INITS);
    }

    public QDiagnosis(Path<? extends Diagnosis> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDiagnosis(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDiagnosis(PathMetadata metadata, PathInits inits) {
        this(Diagnosis.class, metadata, inits);
    }

    public QDiagnosis(Class<? extends Diagnosis> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.disease = inits.isInitialized("disease") ? new QDisease(forProperty("disease")) : null;
        this.pet = inits.isInitialized("pet") ? new QPet(forProperty("pet"), inits.get("pet")) : null;
    }

}

