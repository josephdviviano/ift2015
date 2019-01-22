
void ENQUEUE ( element ) {
  stacky_queue.PUSH (element) //stacky_queue is basically my stack
}

bool DEQUE () {
  If ( NOT stacky_queue.EMPTY()) {
    popped_element = stacky_queue.POP()
    IF ( NOT DEQUE() ) {
      PRINT popped_element
    }
    ELSE {
      stacky_queue.PUSH(popped_element)
    }
    return true
  }
  return false
}

