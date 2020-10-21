package com.groupal.libreriaPrismaBackend.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.groupal.libreriaPrismaBackend.entity.QRolOperacion;
import com.groupal.libreriaPrismaBackend.entity.Rol;
import com.groupal.libreriaPrismaBackend.entity.RolOperacion;
import com.groupal.libreriaPrismaBackend.exception.ResourceNotFoundException;
import com.groupal.libreriaPrismaBackend.repository.RolOperacionRepository;
import com.groupal.libreriaPrismaBackend.repository.RolRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;
    
    @Autowired
    RolOperacionRepository rolOperacionRepository;

    public List<Rol> getAllRoles(){
        return rolRepository.findAll();
    }
    
    
    public Rol getById(Integer rol_id){
    	
    	Optional<Rol> rolDb = this.rolRepository.findById(rol_id);

        if (rolDb.isPresent()) {
            return rolDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + rol_id);
        }
    
    }
    
    
//    
//    public Optional<Rol> listAllRolOperaciones(Long rol_id){
//        return rolRepository.find
//    }
    
//    public Optional<RolOperacion> listAllRolOperaciones(BooleanExpression predicate) {
//    	
////    	Rol rol = rolRepository.findByRolNombre(rolNombre)
//    	
//        return rolOperacionRepository.findAllPredicate(predicate);
//    }
    
    public Iterable<RolOperacion> listAllOperaciones(BooleanExpression predicate) {
//    	Sort sort = new Sort(Sort.Direction.ASC, "irden");
		 
//		 Pageable pageRequest = new PageRequest(pageable.getPageNumber(), 30, sort);
    	
        return rolOperacionRepository.findAll(predicate, Sort.by(Sort.Direction.ASC, "orden"));
    }
    
    public Iterable<RolOperacion> getOperacionesByRol(String rolNombre){
//    	Optional<Rol> rol = rolRepository.findByRolNombre(rolNombre);
    	Rol rol = rolRepository.findByRolNombre(rolNombre).get();
//		 
    	BooleanExpression consulta = QRolOperacion.rolOperacion.id.ne((long) 0);
		consulta = consulta.and(QRolOperacion.rolOperacion.rol.id.eq(rol.getId()));
//		
//		Sort sort = new Sort();	
		
		
//		 Sort sort = new Sort(Sort.Direction.ASC, "nombre");
//		 Pageable pageRequest = new PageRequest(0, 10, sort);
//		 Pageable page = new Pageable(10,"id");
		
		Iterable<RolOperacion> operaciones = listAllOperaciones(consulta);
		
		
//		((Collection<RolOperacion>) operaciones).stream().sorted((p1, p2) -> (p1.getOrden()).compareTo(p2.getOrden()));
		((Collection<RolOperacion>) operaciones).stream().sorted(Comparator.comparingInt(RolOperacion::getOrden));
		ArrayList<RolOperacion> operacionesArray = (ArrayList<RolOperacion>) operaciones;
		
		ArrayList<RolOperacion> operacionesArrayFinal = new ArrayList<RolOperacion>();
		
		for(int i =0 ; i<operacionesArray.size();i++ ) {
			List<RolOperacion> childrens = new ArrayList<RolOperacion>();
    		if(operacionesArray.get(i).getOperacion().getEsPadre()) {
    			for(RolOperacion operacionRol1: operaciones) {
    				if( (operacionesArray.get(i).getOrden() == operacionRol1.getOrden()) && (!operacionRol1.getOperacion().getEsPadre()) ) {
    					childrens.add(operacionRol1);
    				}
    			}
    			
    			operacionesArray.get(i).setChildrens(childrens);
    			
    			operacionesArrayFinal.add(operacionesArray.get(i));
    		}
    	}
    	
        return operacionesArrayFinal;
    }
}
