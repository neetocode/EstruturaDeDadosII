using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArvoreBinaria
{
    class No<T>
    {
        public T Valor { get; set; }
        public No<T> Esquerdo { get; set; }
        public No<T> Direito { get; set; }
    }
}