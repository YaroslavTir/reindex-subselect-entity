package com.yaroslavtir.entity;

import lombok.Getter;
import org.hibernate.annotations.Subselect;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexingDependency;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.ObjectPath;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.PropertyValue;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Getter
@Indexed
@Entity
@Subselect("select * from main")
//@Table(name = "main")
//@Immutable
public class ThirdEntity {
    @Id
    private Long id;

    @ManyToOne
    private SecondEntity secondaryEntity;

    @Transient
    @GenericField(sortable = Sortable.YES)
    @IndexingDependency(derivedFrom = {
            @ObjectPath(@PropertyValue(propertyName = "secondaryEntity"))
    })
    public String getName() {
        return secondaryEntity.getName();
    }
}
