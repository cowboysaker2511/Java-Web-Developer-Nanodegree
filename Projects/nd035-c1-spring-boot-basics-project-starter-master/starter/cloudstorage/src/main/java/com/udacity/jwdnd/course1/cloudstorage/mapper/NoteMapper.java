package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    List<Note> getNoteListByUserId(int userId);

    @Insert("INSERT INTO NOTES(notetitle, notedescription, userid) " +
            "VALUES(#{noteTitle}, #{noteDescription}, #{userId})")
    int addNote(String noteTitle, String noteDescription, int userId);

    @Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription} WHERE noteid = #{noteId}")
    int saveNote(int noteId, String noteTitle, String noteDescription, int userId);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    int deleteNoteByNoteId(int noteId);
}
