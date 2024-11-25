package ma.znagui.app.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import ma.znagui.app.dto.tree.TreeCreateDTO;
import ma.znagui.app.dto.tree.TreeResponseDTO;
import ma.znagui.app.entity.Field;
import ma.znagui.app.entity.Tree;
import ma.znagui.app.exception.TreeCannotBePlantedException;
import ma.znagui.app.mapper.TreeMapper;
import ma.znagui.app.repository.TreeRepository;
import ma.znagui.app.service.FieldService;
import ma.znagui.app.service.TreeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TreeServiceImplTest {

    @Mock
    private TreeMapper mapper;
    @Mock
    private FieldService fieldService;
    @Mock
    private TreeRepository repository;

    @InjectMocks
    private TreeServiceImpl treeService;


    @Test
    public void testCreateTree_NoError() {
        TreeCreateDTO dto = new TreeCreateDTO();
        dto.setFieldID(1L);
        dto.setPlantingDate(LocalDate.of(2022 ,05 , 31 ));

        Tree tree = new Tree();
        tree.setPlantingDate(LocalDate.of(2022 ,05 , 31 ));
        Field f = new Field();
        f.setId(1L);
        tree.setField(f);
        tree.setPlantingDate(dto.getPlantingDate());

        Field field = new Field();
        field.setId(1L);


        when(mapper.createDTOtoTree(dto)).thenReturn(tree);
        when(fieldService.getFieldEntityByID(1L)).thenReturn(field);
        when(fieldService.isFieldacceptNowTree(field)).thenReturn(true);
        when(repository.save(tree)).thenReturn(tree);
        when(mapper.treeToResponseDTO(tree)).thenReturn(new TreeResponseDTO());

        TreeResponseDTO result = treeService.create(dto);

        assertNotNull(result);
        verify(repository,times(1)).save(tree);
    }

    @Test
    public void testCreateTree_FieldNotFound() {
        TreeCreateDTO dto = new TreeCreateDTO();
        dto.setFieldID(99L);
        dto.setPlantingDate(LocalDate.of(2022 ,05 , 31 ));
        Field f = new Field();
        f.setId(99L);


        Tree t = new Tree();
        t.setField(f);
        when(mapper.createDTOtoTree(dto)).thenReturn(t);
        when(fieldService.getFieldEntityByID(99L)).thenThrow(new EntityNotFoundException("Field not found"));

        Assertions.assertThrows(EntityNotFoundException.class, () -> treeService.create(dto));

        verify(repository, never()).save(any(Tree.class));
    }


    @Test
    public void testCreateTree_FieldMaxTreesError() {
        TreeCreateDTO dto = new TreeCreateDTO();
        dto.setFieldID(1L);
        dto.setPlantingDate(LocalDate.of(2022 ,05 , 31 ));

        Tree tree = new Tree();
        Field f = new Field();
        f.setId(1L);
        f.setArea(2000.0) ;
        tree.setField(f);
        tree.setPlantingDate(dto.getPlantingDate());
        List<Tree> trees= new ArrayList<>();
        for (int i=0 ; i < 30 ; i++){
            trees.add(new Tree());
        }
        f.setTrees(trees);

        when(mapper.createDTOtoTree(dto)).thenReturn(tree);
        when(fieldService.getFieldEntityByID(1L)).thenReturn(f);


        Assertions.assertThrows(TreeCannotBePlantedException.class, () -> treeService.create(dto));

        verify(repository, never()).save(any(Tree.class));
    }



}