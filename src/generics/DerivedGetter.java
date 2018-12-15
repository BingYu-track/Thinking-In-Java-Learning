package generics;

interface DerivedGetter extends OrdinaryGetter{

    // Return type of overridden method is allowed to vary:
    Derived get();
}
