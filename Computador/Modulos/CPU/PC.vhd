-- Contador de 16bits
-- if (reset[t] == 1) out[t+1] = 0
-- else if (load[t] == 1)  out[t+1] = in[t]
-- else if (inc[t] == 1) out[t+1] = out[t] + 1
-- else out[t+1] = out[t]

library ieee;
use ieee.std_logic_1164.all;

entity PC is
    port(
        clock     : in  STD_LOGIC;
		increment : in  STD_LOGIC;
		load      : in  STD_LOGIC;
		reset     : in  STD_LOGIC;
        input     : in  STD_LOGIC_VECTOR(15 downto 0);
        output    : out STD_LOGIC_VECTOR(14 downto 0)
    );
end entity;

architecture arch_PC of PC is

signal os1:STD_LOGIC_VECTOR(15 downto 0);
signal os2:STD_LOGIC_VECTOR(15 downto 0);
signal os3:STD_LOGIC_VECTOR(15 downto 0);
signal os4:STD_LOGIC_VECTOR(15 downto 0);
signal os5:STD_LOGIC;
signal os6:STD_LOGIC;
signal os7:STD_LOGIC_VECTOR(15 downto 0);

component Register16 is
	port(
			clock:   in STD_LOGIC;
			input:   in STD_LOGIC_VECTOR(15 downto 0);
			load:    in STD_LOGIC;
			output: out STD_LOGIC_VECTOR(15 downto 0)
		);
	end component;

	component Add16 is
		port(
			a   :  in STD_LOGIC_VECTOR(15 downto 0);
			b   :  in STD_LOGIC_VECTOR(15 downto 0);
			q   : out STD_LOGIC_VECTOR(15 downto 0) 
		); 
	end component; 

	component Mux16 is
	
	port ( 
			a:   in  STD_LOGIC_VECTOR(15 downto 0);
			b:   in  STD_LOGIC_VECTOR(15 downto 0);
			sel: in  STD_LOGIC;
			q:   out STD_LOGIC_VECTOR(15 downto 0));
	
	end component;

component Not16 is
	port ( 
			a:   in  STD_LOGIC_VECTOR(15 downto 0);
			q:   out STD_LOGIC_VECTOR(15 downto 0));
end component;

component And16 is
	port ( 
			a:   in  STD_LOGIC_VECTOR(15 downto 0);
			b:   in  STD_LOGIC_VECTOR(15 downto 0);
			q:   out STD_LOGIC_VECTOR(15 downto 0));
end component;

begin
	s1: Mux16 port map (input,os4,os5,os1);
	s2: Mux16 port map (os1,"0000000000000000",reset,os2); 
	s3: Register16 port map (clock, os2, os6, os3); 
	s4: Add16 port map (os3, os7 , os4);
    
	os7 <= "000000000000000"&increment;
	os5 <= not load;
	os6 <= load or reset or increment;
	output <= os3(14 downto 0);

end architecture;