void Embellishment::Draw(Window* w) {
  _component->Draw(w);
}

void Border::Draw(Window* w) {
  Embellishment::Draw(w);
  DrawBorder(w);
}
