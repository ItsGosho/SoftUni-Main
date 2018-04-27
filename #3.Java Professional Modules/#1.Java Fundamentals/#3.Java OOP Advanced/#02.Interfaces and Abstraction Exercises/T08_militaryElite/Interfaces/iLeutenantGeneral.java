package T08_militaryElite.Interfaces;

import T08_militaryElite.Models.Private;

import java.util.List;

public interface iLeutenantGeneral extends iPrivate{
    List<Private> getPrivates();
}
