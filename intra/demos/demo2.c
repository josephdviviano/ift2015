typedef struct _node node;


list* push(list *l, node* n){
}

node *pop(list *l){
}

int reverseit(list *l) {
  if(l==NULL)
    return 0; 
  list l2 = {.first = l->first};
  while(n->next != NULL) {
    push(l2, pop(l2));
  }
}

int reverseit_jhlim(list *l) {
  if(l==NULL)
    return 0;
  node * parent = NULL;
  node * child  = NULL; 

  node * n = l.first;
  while(n->next != NULL) {
    child = n->next;
    n->next = parent;
    parent = *n;
    n = child;
  }

  l.first = n; 
}
