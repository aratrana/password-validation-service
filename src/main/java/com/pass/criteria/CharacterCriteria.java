package com.pass.criteria;

public interface CharacterCriteria extends Criteria {
    void setNumberOfCharacters(int n);

    /**get number of characters from password**/
    int getNumberOfCharacters();

    /**get valid characters**/
    String getValidCharacters();
}
