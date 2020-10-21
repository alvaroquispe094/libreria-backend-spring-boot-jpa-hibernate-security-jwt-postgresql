package com.groupal.libreriaPrismaBackend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOperacion is a Querydsl query type for Operacion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOperacion extends EntityPathBase<Operacion> {

    private static final long serialVersionUID = 1236169450L;

    public static final QOperacion operacion = new QOperacion("operacion");

    public final BooleanPath activo = createBoolean("activo");

    public final BooleanPath esPadre = createBoolean("esPadre");

    public final BooleanPath group = createBoolean("group");

    public final BooleanPath home = createBoolean("home");

    public final StringPath icon = createString("icon");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath link = createString("link");

    public final StringPath title = createString("title");

    public QOperacion(String variable) {
        super(Operacion.class, forVariable(variable));
    }

    public QOperacion(Path<? extends Operacion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOperacion(PathMetadata metadata) {
        super(Operacion.class, metadata);
    }

}

