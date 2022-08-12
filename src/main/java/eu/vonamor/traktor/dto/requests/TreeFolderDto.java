package eu.vonamor.traktor.dto.requests;

import java.util.List;

public class TreeFolderDto {
    public long id;
    public String name;
    public List<TreeRequestDto> requests;
    public List<TreeFolderDto> folders;
}
