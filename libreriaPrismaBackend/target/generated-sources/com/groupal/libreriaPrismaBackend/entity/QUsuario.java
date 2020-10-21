package com.groupal.libreriaPrismaBackend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsuario is a Querydsl query type for Usuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsuario extends EntityPathBase<Usuario> {

    private static final long serialVersionUID = 1189615488L;

    public static final QUsuario usuario1 = new QUsuario("usuario1");

    public final BooleanPath activo = createBoolean("activo");

    public final StringPath apellido = createString("apellido");

    public final StringPath direccion = createString("direccion");

    public final StringPath documento = createString("documento");

    public final StringPath email = createString("email");

    public final StringPath fechaNacimiento = createString("fechaNacimiento");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nombre = createString("nombre");

    public final StringPath password = createString("password");

    public final SetPath<Rol, QRol> roles = this.<Rol, QRol>createSet("roles", Rol.class, QRol.class, PathInits.DIRECT2);

    public final StringPath usuario = createString("usuario");

    public QUsuario(String variable) {
        super(Usuario.class, forVariable(variable));
    }

    public QUsuario(Path<? extends Usuario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsuario(PathMetadata metadata) {
        super(Usuario.class, metadata);
    }

}

