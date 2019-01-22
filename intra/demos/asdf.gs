1 1 100
{
    % i
    dup
    % i i
    10 mod
    % i r 
    % a b eq { ... } if
    0 eq
    % i r=0?
    { % branche if
        % i
        =
    }
    { % branche else
        % i
        pop
    } ifelse
} for


for (i=1,2,...100)
{
    if (i mod 10 == 0) then afficher i
}

/mystique
{
    2 copy gt {exch} if pop
} def

