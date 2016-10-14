using System;
using System.Collections;
using System.Collections.Generic;

namespace ArvoreBinaria
{
    class No<T>
    {
        public T Valor { get; set; }
        public No<T> Esquerdo { get; set; }
        public No<T> Direito { get; set; }

        public No(T valor)
        {
            Valor = valor;
        }
        public No(T valor,No<T> esquerdo)
        {
            Valor = valor;
            Esquerdo = esquerdo;
        }
        public No(T valor, No<T> esquerdo, No<T> direito)
        {
            Valor = valor;
            Esquerdo = esquerdo;
            Direito = direito;
        }

        public int Compare(T x)
        {
            Comparer comp = new Comparer(new System.Globalization.CultureInfo("pt-BR", false));
            return comp.Compare(Valor, x);
        }
    }
}